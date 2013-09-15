package org.springframework.web.servlet.view.velocity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

public class ExtendVelocityLayoutViewResolver extends VelocityLayoutViewResolver {

	private Map<String, Object> toolsMap = new HashMap<String, Object>();

	private Map<String, String> layoutMap = new HashMap<String, String>();

	@Override
	protected Class<?> requiredViewClass() {
		return ExtendVelocityLayoutView.class;
	}

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		ExtendVelocityLayoutView view = (ExtendVelocityLayoutView) super.buildView(viewName);
		view.setToolsMap(toolsMap);
		if (layoutMap.containsKey(viewName)) {
			view.setLayoutUrl(layoutMap.get(viewName));
		}
		return view;
	}

	public void setToolsMap(Map<String, Object> toolsMap) {
		this.toolsMap = toolsMap;
	}

	public void setLayoutMap(Map<String, String> layoutMap) {
		this.layoutMap = layoutMap;
	}
}
