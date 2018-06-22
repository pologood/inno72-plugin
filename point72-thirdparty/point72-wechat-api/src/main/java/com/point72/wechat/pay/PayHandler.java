package com.point72.wechat.pay;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.point72.image.QrcodeUtil;
import com.point72.plugin.http.HttpClient;
import com.point72.wechat.ApiUrl.Pay;
import com.point72.wechat.pay.request.model.BillCommentModel;
import com.point72.wechat.pay.request.model.CloseOrderModel;
import com.point72.wechat.pay.request.model.DownloadBillModel;
import com.point72.wechat.pay.request.model.FindOrderModel;
import com.point72.wechat.pay.request.model.FindRefundOrderModel;
import com.point72.wechat.pay.request.model.PayReportModel;
import com.point72.wechat.pay.request.model.RefundOrderModel;
import com.point72.wechat.pay.request.model.UnifieOrderModel;
import com.point72.wechat.pay.response.model.CloseOrderResponseModel;
import com.point72.wechat.pay.response.model.FindOrderResponseModel;
import com.point72.wechat.pay.response.model.FindRefundOrderResponseModel;
import com.point72.wechat.pay.response.model.PayReportResponseModel;
import com.point72.wechat.pay.response.model.RefundOrderResponseModel;
import com.point72.wechat.pay.response.model.UnifieOrderResponseModel;
import com.point72.wechat.tools.SignHelper;

/**
 * 微信支付相关接口(包含生成支付相关二维码)
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class PayHandler {

	private static Logger logger = LoggerFactory.getLogger(PayHandler.class);

	/**
	 * 统一下单
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static UnifieOrderResponseModel unifieOrder(UnifieOrderModel model, String keycode) {
		String result = HttpClient.post(Pay.Order.url(), model.toXml(keycode));
		UnifieOrderResponseModel response = new UnifieOrderResponseModel(result);
		return response;
	}

	/**
	 * 查询订单
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static FindOrderResponseModel findOrder(FindOrderModel model, String keycode) {
		String result = HttpClient.post(Pay.Find.url(), model.toXml(keycode));
		FindOrderResponseModel response = new FindOrderResponseModel(result);
		return response;
	}

	/**
	 * 关闭订单
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static CloseOrderResponseModel closeOrder(CloseOrderModel model, String keycode) {
		String result = HttpClient.post(Pay.Close.url(), model.toXml(keycode));
		CloseOrderResponseModel response = new CloseOrderResponseModel(result);
		return response;
	}

	/**
	 * 退款
	 * 
	 * @param model
	 * @param keycode
	 * @param certificatePath
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static RefundOrderResponseModel refundOrder(RefundOrderModel model, String keycode, String certificatePath,
			String password) {
		RefundOrderResponseModel response = null;
		InputStream inputStream = null;
		KeyStore keyStroe = null;
		try {
			inputStream = new FileInputStream(new File(certificatePath));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			keyStroe = KeyStore.getInstance("PKCS12");
			keyStroe.load(inputStream, password.toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			SSLContext sslContext = SSLContext.getInstance("TLSv1");
			KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
			keyManagerFactory.init(keyStroe, password.toCharArray());
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
			trustManagerFactory.init((KeyStore) null);
			TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
			sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers, new SecureRandom());
			SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

			X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

			// String result = HttpClient.ssl(Pay.Refund.url(), model.toXml(keycode), sslSocketFactory, trustManager);
			String result = ""; // todo
			logger.info("退款接口结果: {}", result);
			response = new RefundOrderResponseModel(result);
		} catch (NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException | KeyManagementException e1) {
			e1.printStackTrace();
		}
		return response;
	}

	/**
	 * 查询退款
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static FindRefundOrderResponseModel findRefundOrder(FindRefundOrderModel model, String keycode) {
		String result = HttpClient.post(Pay.FindRefund.url(), model.toXml(keycode));
		FindRefundOrderResponseModel response = new FindRefundOrderResponseModel(result);
		return response;
	}

	/**
	 * 下载对账单数据
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static String downloadBill(DownloadBillModel model, String keycode) {
		String result = HttpClient.post(Pay.DownloadBill.url(), model.toXml(keycode));
		return result;
	}

	/**
	 * 交易保障
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static PayReportResponseModel findRefundOrder(PayReportModel model, String keycode) {
		String result = HttpClient.post(Pay.Report.url(), model.toXml(keycode));
		PayReportResponseModel response = new PayReportResponseModel(result);
		return response;
	}

	/**
	 * 拉取订单评价数据
	 * 
	 * @param model
	 * @param keycode
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	public static String billComment(BillCommentModel model, String keycode) {
		String result = HttpClient.post(Pay.BillComment.url(), model.toXml(keycode));
		return result;
	}

	/**
	 * 生成扫码支付二维码到给定的流中
	 * 
	 * @param appid
	 * @param mchId
	 * @param productId
	 *            商品ID
	 * @param timestamp
	 * @param nonceStr
	 * @param keycode
	 *            商户密钥
	 * @param stream
	 * @param width
	 * @param height
	 * @author Houkm 2017年9月7日
	 */
	public static void generateScanPayQrcode(String appid, String mchId, String productId, String timestamp,
			String nonceStr, String keycode, OutputStream stream, int width, int height) {
		String url = generateScanPayUrl(appid, mchId, productId, timestamp, nonceStr, keycode);
		QrcodeUtil.generate(url, "jpg", stream, width, height);
	}

	/**
	 * 生成扫码支付二维码到给定的文件中
	 * 
	 * @param appid
	 * @param mchId
	 * @param productId
	 *            商品ID
	 * @param timestamp
	 * @param nonceStr
	 * @param keycode
	 *            商户密钥
	 * @param distFile
	 * @param width
	 * @param height
	 * @author Houkm 2017年9月7日
	 */
	public static void generateScanPayQrcode(String appid, String mchId, String productId, String timestamp,
			String nonceStr, String keycode, File distFile, int width, int height) {
		String url = generateScanPayUrl(appid, mchId, productId, timestamp, nonceStr, keycode);
		QrcodeUtil.generate(url, "jpg", distFile, width, height);
	}

	/**
	 * 生成扫码支付二维码到给定的流中
	 * 
	 * @param appid
	 * @param mchId
	 * @param productId
	 *            商品ID
	 * @param timestamp
	 * @param nonceStr
	 * @param keycode
	 *            商户密钥
	 * @param width
	 * @param height
	 * @return 二维码BufferedImage
	 * @author Houkm 2017年9月7日
	 */
	public static BufferedImage generateScanPayQrcode(String appid, String mchId, String productId, String timestamp,
			String nonceStr, String keycode, int width, int height) {
		String url = generateScanPayUrl(appid, mchId, productId, timestamp, nonceStr, keycode);
		return QrcodeUtil.generate(url, width, height);
	}

	/**
	 * 根据统一下单接口返回数据中的codeUrl生成支付二维码
	 * 
	 * @param codeUrl
	 * @param stream
	 * @param size
	 * @author Houkm 2017年9月7日
	 */
	public static void generateScanPayQrcode(String codeUrl, OutputStream stream, int... size) {
		QrcodeUtil.generate(codeUrl, "jpg", stream, size);
	}

	/**
	 * 根据统一下单接口返回数据中的codeUrl生成支付二维码
	 * 
	 * @param codeUrl
	 * @param distFile
	 * @param size
	 * @author Houkm 2017年9月7日
	 */
	public static void generateScanPayQrcode(String codeUrl, File distFile, int... size) {
		QrcodeUtil.generate(codeUrl, "jpg", distFile, size);
	}

	/**
	 * 根据统一下单接口返回数据中的codeUrl生成支付二维码
	 * 
	 * @param codeUrl
	 * @param size
	 * @return 二维码BufferedImage
	 * @author Houkm 2017年9月7日
	 */
	public static BufferedImage generateScanPayQrcode(String codeUrl, int... size) {
		return QrcodeUtil.generate(codeUrl, size);
	}

	/**
	 * jsapi调起支付签名
	 * 
	 * @param appId
	 * @param nonceStr
	 * @param timestamp
	 * @param prepayId
	 * @param keycode
	 * @return
	 * @author Houkm 2017年10月9日
	 */
	public static Map<String, String> jsPaySign(String appId, String nonceStr, String timestamp, String prepayId,
			String keycode) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("appId", appId);
		map.put("nonceStr", nonceStr);
		map.put("package", "prepay_id=" + prepayId);
		map.put("timeStamp", timestamp);
		map.put("signType", "MD5");

		StringBuffer sb = new StringBuffer();

		map.forEach((k, v) -> {
			sb.append(k).append("=").append(v).append("&");
		});

		sb.append("key=").append(keycode);

		String str = sb.toString();

		String paySign = SignHelper.MD5(str);
		map.put("paySign", paySign);

		return map;
	}

	private static String generateScanPayUrl(String appid, String mchId, String productId, String timestamp,
			String nonceStr, String keycode) {
		String api = "weixin://wxpay/bizpayurl?sign={0}&appid={1}&mch_id={2}&product_id={3}&time_stamp={4}&nonce_str={5}";
		Map<String, String> map = new TreeMap<>();
		map.put("appid", appid);
		map.put("mch_id", mchId);
		map.put("product_id", productId);
		map.put("time_stamp", timestamp);
		map.put("nonce_str", nonceStr);

		StringBuffer sb = new StringBuffer();

		map.forEach((k, v) -> {
			sb.append(k).append("=").append(v).append("&");
		});

		sb.append("key=").append(keycode);

		String sign = sb.toString();

		sign = SignHelper.MD5(sign).toUpperCase();
		return MessageFormat.format(api, sign, appid, mchId, productId, timestamp, nonceStr);
	}
}
