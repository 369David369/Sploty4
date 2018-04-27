package me.david.sploty4.dom.css.selectors.normal;

import me.david.sploty4.document.text.HtmlDocument;
import me.david.sploty4.dom.css.selectors.SimpleSelector;
import me.david.sploty4.dom.html.StyleableNode;

import java.util.Arrays;

public class ClassSelector extends SimpleSelector {

    public ClassSelector(String select) {
        super('.', select);
    }

    @Override
    public boolean valid(StyleableNode node, HtmlDocument document) {
        if (!node.hasAttribute("class")) return false;
        String[] classes = node.getStandartAttribute("class").getValue().split(" ");
        return Arrays.stream(classes).anyMatch(name -> name.equalsIgnoreCase(select));
    }
}
