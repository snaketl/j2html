package j2html.tags;

import j2html.attributes.*;

public class EmptyTag extends Tag<EmptyTag> {

    public EmptyTag(String tagType) {
        super(tagType);
    }

    public String render() {
        String tagAttributes = "";
        for (Attribute attribute : attributes) {
            tagAttributes += attribute;
        }
        return "<" + tag + tagAttributes + ">";
    }

    @Override
    public String toString() {
        return this.render();
    }

}
