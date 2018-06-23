package com.inno72.ddtalk.boot;

import com.inno72.ddtalk.model.ChatCallbackModel;

public interface ChatCallbackListener {

	void process(ChatCallbackModel model);

}
