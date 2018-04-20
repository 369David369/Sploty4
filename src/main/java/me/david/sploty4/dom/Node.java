package me.david.sploty4.dom;

import me.david.sploty4.dom.atriute.Attribute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node implements Cloneable {

    private final String name;

    private Node parent;
    private List<Node> childs;

    private Set<Attribute> attributes;

    public Node(String name) {
        this.name = name;
        childs = new ArrayList<>();
        attributes = new HashSet<>();
    }

    public Node(String name, Node parent) {
        this.name = name;
        this.parent = parent;
        childs = new ArrayList<>();
        attributes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public boolean hasAttriute(String name){
        for(Attribute attribute : attributes)
            if(attribute.getName().equals(name))
                return true;
        return false;
    }

    public Attribute getAttribute(String name){
        for(Attribute attribute : attributes)
            if(attribute.getName().equals(name))
                return attribute;
        return null;
    }

    @Override
    public Node clone() {
        try {
            return (Node) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (getName() != null ? !getName().equals(node.getName()) : node.getName() != null) return false;
        if (getParent() != null ? !getParent().equals(node.getParent()) : node.getParent() != null) return false;
        if (getChilds() != null ? !getChilds().equals(node.getChilds()) : node.getChilds() != null) return false;
        return getAttributes() != null ? getAttributes().equals(node.getAttributes()) : node.getAttributes() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
        result = 31 * result + (getChilds() != null ? getChilds().hashCode() : 0);
        result = 31 * result + (getAttributes() != null ? getAttributes().hashCode() : 0);
        return result;
    }
}
