package com.cleaner.TagCleaner;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class TagNodePage implements TagNodeEntity {

	private TagNode tagNode;

	public TagNodePage(String data) {
		tagNode = new HtmlCleaner().clean(data);
	}
	
	public TagNodeElement getTagNodeElement() {
		return new TagNodeElement(tagNode);
	}

	@Override
	public TagNode getNode() {
		return tagNode;
	}

}
