package j2html.tags;

import j2html.attributes.*;
import java.util.*;

public class ContainerTag extends Tag<ContainerTag> {

    public List<Tag> children;

    public ContainerTag(String tagType) {
        super(tagType);
        this.children = new ArrayList<>();
    }

    /**
     * Appends a tag to the end of this element
     *
     * @param child tag to be appended
     * @return itself for easy chaining
     */
    public ContainerTag with(Tag child) {
        if (this == child) {
            throw new Error("Cannot append a tag to itself.");
        }
        child.setParent(this);
        children.add(child);
        return this;
    }

    /**
     * Call with-method based on condition
     * {@link #with(Tag child)}
     */
    public ContainerTag condWith(boolean condition, Tag child) {
        return condition ? this.with(child) : this;
    }

    /**
     * Appends a list of tags to the end of this element
     *
     * @param children tags to be appended
     * @return itself for easy chaining
     */
    public ContainerTag with(List<Tag> children) {
        if (children != null) {
            for (Tag child : children) {
                this.with(child);
            }
        }
        return this;
    }

    /**
     * Call with-method based on condition
     * {@link #with(List children)}
     */
    public ContainerTag condWith(boolean condition, List<Tag> children) {
        return condition ? this.with(children) : this;
    }

    /**
     * Appends the tags to the end of this element
     *
     * @param children tags to be appended
     * @return itself for easy chaining
     */
    public ContainerTag with(Tag... children) {
        for (Tag aChildren : children) {
            with(aChildren);
        }
        return this;
    }

    /**
     * Call with-method based on condition
     * {@link #with(Tag... children)}
     */
    public ContainerTag condWith(boolean condition, Tag... children) {
        return condition ? this.with(children) : this;
    }

    /**
     * Appends a text tag to this element
     *
     * @param text the text to be appended
     * @return itself for easy chaining
     */
    public ContainerTag withText(String text) {
        return with(new Text(text));
    }

    /**
     * Render the tag and its children
     */
    @Override
    public String render() {
        StringBuilder rendered = new StringBuilder(renderOpenTag());
        if (children != null && children.size() > 0) {
            for (Tag child : children) {
                rendered.append(child.render());
            }
        }
        rendered.append(renderCloseTag());
        return rendered.toString();
    }

    @Override
    public String toString() {
        return this.render();
    }

}
