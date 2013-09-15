package com.dcr.cms.entity;

public class Channel extends BaseEntity {

	/**
	 * 栏目名称（中文）
	 */
	private String name;

	/**
	 * 栏目英文路径
	 */
	private String path;

	/**
	 * 栏目描述
	 */
	private String description;

	/**
	 * 父栏目
	 */
	private Channel parent;

	/**
	 * 栏目首页模板
	 */
	private String channelTemplate;

	/**
	 * 栏目列表页模板
	 */
	private String channelListTemplate;

	/**
	 * 栏目内容页模板
	 */
	private String channelContentTemplate;

	/**
	 * SEO 栏目meta title
	 */
	private String metaTitle;

	/**
	 * SEO 栏目关键字
	 */
	private String metaKeywords;

	/**
	 * SEO 栏目描述
	 */
	private String metaDescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	public String getChannelTemplate() {
		return channelTemplate;
	}

	public void setChannelTemplate(String channelTemplate) {
		this.channelTemplate = channelTemplate;
	}

	public String getChannelListTemplate() {
		return channelListTemplate;
	}

	public void setChannelListTemplate(String channelListTemplate) {
		this.channelListTemplate = channelListTemplate;
	}

	public String getChannelContentTemplate() {
		return channelContentTemplate;
	}

	public void setChannelContentTemplate(String channelContentTemplate) {
		this.channelContentTemplate = channelContentTemplate;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
}
