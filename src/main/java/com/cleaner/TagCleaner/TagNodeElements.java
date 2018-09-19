package com.cleaner.TagCleaner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.htmlcleaner.TagNode;

/**
 * Intended for operations on List of TagNodeElement defined as TagNodeElements
 * 
 * @author Vikas Raj
 * @version 1.0
 *
 */
public class TagNodeElements implements Iterable<TagNodeElement> {

	private List<TagNodeElement> nodes;

	public TagNodeElements(List<TagNode> nodes) {
		this.nodes = new LinkedList<>();
		for (TagNode element : nodes) {
			this.nodes.add(new TagNodeElement(element));
		}
	}

	/**
	 * fetch first element
	 * 
	 * @return
	 */
	public TagNodeElement first() {
		return nodes.isEmpty() ? null : nodes.get(0);
	}

	/**
	 * fetch last element
	 * 
	 * @return
	 */
	public TagNodeElement last() {
		return nodes.isEmpty() ? null : nodes.get(nodes.size() - 1);
	}

	/**
	 * fetch element at position n
	 * 
	 * @param n
	 * @return
	 */
	public TagNodeElement get(int n) {
		return nodes.isEmpty() ? null : nodes.get(n);
	}

	/** 
	 * Fetch the Number of elements present
	 * 
	 * @return
	 */
	public int length() {
		return nodes.isEmpty() ? 0 : nodes.size();
	}

	/**
	 * Checks if the the Object is empty
	 * 
	 * @return
	 */
	public boolean isNotEmpty() {
		return length() > 0;
	}

	/**
	 * Fetch the list of text of all the nodes
	 * 
	 * @return
	 */
	public List<String> texts() {
		List<String> texts = new ArrayList<>();
		for (TagNodeElement node : nodes) {
			texts.add(node.text());
		}
		return texts;
	}

	@Override
	public Iterator<TagNodeElement> iterator() {
		return nodes.iterator();
	}

}
