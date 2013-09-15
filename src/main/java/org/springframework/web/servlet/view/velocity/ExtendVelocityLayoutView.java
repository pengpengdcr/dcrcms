package org.springframework.web.servlet.view.velocity;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.context.Context;

public class ExtendVelocityLayoutView extends VelocityLayoutView {

	private Map<String,Object> toolsMap = new HashMap<String,Object>();

	public void setToolsMap(Map<String, Object> toolsMap) {
		this.toolsMap = toolsMap;
	}
	
	@Override
	protected void exposeToolAttributes(Context velocityContext, HttpServletRequest request) throws Exception {
		super.exposeToolAttributes(velocityContext, request);
		
		for(String tool : toolsMap.keySet()){
			velocityContext.put(tool, toolsMap.get(tool));
		}
	}
}
