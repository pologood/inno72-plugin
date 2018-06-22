package com.point72.ddtalk.boot;

import com.point72.ddtalk.model.ChatCallbackModel;

public interface ChatCallbackListener {

	void process(ChatCallbackModel model);

}
