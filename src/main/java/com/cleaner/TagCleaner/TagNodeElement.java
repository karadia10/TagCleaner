package com.cleaner.TagCleaner;

import org.htmlcleaner.TagNode;

public class TagNodeElement implements TagNodeEntity {

	private TagNode tagNode;

	public TagNodeElement(TagNode tagNode) {
		this.tagNode = tagNode;
	}

	@Override
	public TagNode getNode() {
		return tagNode;
	}
	
	public TagNodeElement nodeByattrValue(String attName, String attValue) {
		return new TagNodeElement(tagNode.findElementByAttValue(attName, attValue, true, false));
	}
	
	public TagNodeElement nodeByName(String name) {
		return new TagNodeElement(tagNode.findElementByName(name, true));
	}
	
	public TagNodeElement a() {
		return nodeByName("a");
	}

	public TagNodeElement img() {
		return nodeByName("img");
	}

	public String attr(String attr) {
		return tagNode.getAttributeByName(attr);
	}

	public String href() {
		return attr("href");
	}

	public String src() {
		return attr("src");
	}

	public String alt() {
		return attr("alt");
	}

	public String content() {
		return attr("content");
	}

	public String value() {
		return attr("value");
	}

	public String text() {
		return tagNode.getText() != null ? tagNode.getText().toString().trim() : "";
	}

	public TagNodeElement parent() {
		return new TagNodeElement(tagNode.getParent());
	}

}
