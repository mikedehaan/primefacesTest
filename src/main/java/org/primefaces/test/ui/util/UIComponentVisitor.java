package org.primefaces.test.ui.util;

import javax.faces.component.UIComponent;

/**
 * User: mdehaan
 * Date: 8/6/13
 */
public interface UIComponentVisitor {

    /**
     * Return false to stop the visitor from traversing the tree.
     *
     * @param component The component currently being analyzed
     * @param depth Current depth of the component relative to the starting component
     * @return Return false to stop the visitor from traversing the tree.
     */
    boolean visit(UIComponent component, int depth);
}
