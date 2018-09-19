package com.cleaner.TagCleaner;

import java.util.Arrays;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 * Interface TagNode related classes
 * 
 * @author Vikas Raj
 * @version 1.0
 *
 */
public interface TagNodeEntity {

	abstract TagNode getNode();

	/**
	 * Find all nodes containing attribute Name with a value
	 * 
	 * @param attrName
	 * @param attrValue
	 * @return
	 */
	default TagNodeElements nodesByattrValue(String attrName, String attrValue) {
		TagNode[] nodes = getNode().getElementsByAttValue(attrName, attrValue, true, false);
		return (nodes != null && nodes.length > 0) ? new TagNodeElements(Arrays.asList(nodes)) : null;
	}

	/**
	 * Find all nodes containing attribute("class") with a value
	 * 
	 * @param classValue
	 * @return
	 */
	default TagNodeElements classValue(String classValue) {
		return nodesByattrValue("class", classValue);
	}

	/**
	 * Find all nodes containing attribute("itemprop") with a value
	 * 
	 * @param itempropValue
	 * @return
	 */
	default TagNodeElements itempropValue(String itempropValue) {
		return nodesByattrValue("itemprop", itempropValue);
	}

	/**
	 * Find all nodes containing attribute("type") with a value
	 * 
	 * @param typeValue
	 * @return
	 */
	default TagNodeElements typeValue(String typeValue) {
		return nodesByattrValue("type", typeValue);
	}

	/**
	 * Find all nodes containing attribute("title") with a value
	 * 
	 * @param titleValue
	 * @return
	 */
	default TagNodeElements titleValue(String titleValue) {
		return nodesByattrValue("title", titleValue);
	}

	/**
	 * Find all nodes by element name
	 * 
	 * @param name
	 * @return
	 */
	default TagNodeElements nodesByName(String name) {
		TagNode[] nodes = getNode().getElementsByName(name, true);
		return (nodes != null && nodes.length > 0) ? new TagNodeElements(Arrays.asList(nodes)) : null;
	}

	/**
	 * Find all nodes by element name("li") i.e. html list
	 * 
	 * @return
	 */
	default TagNodeElements li() {
		return nodesByName("li");
	}

	/**
	 * Get inner HTML of the node in string format
	 * 
	 * @return
	 */
	default String innerHtml() {
		return new HtmlCleaner().getInnerHtml(getNode());
	}

}
