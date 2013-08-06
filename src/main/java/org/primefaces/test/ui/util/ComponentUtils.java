package org.primefaces.test.ui.util;

import javax.faces.component.UIComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: mdehaan
 * Date: 8/6/13
 */
public class ComponentUtils {

    /**
     * Find a list of components starting at the baseComponent that is of
     * the type clazz.  This does not check 'instanceof'.  This is an exact
     * match.
     *
     * @param baseComponent
     * @param clazz
     * @param <S>
     * @return
     */
    public static <S extends UIComponent> List<S> findComponentsByClassName(UIComponent baseComponent, final Class<S> clazz) {
        final List<S> results = new ArrayList<>();
        recurseChildren(baseComponent, 0, new UIComponentVisitor() {
            @Override
            public boolean visit(UIComponent component, int depth) {
                if (clazz.getName().equals(component.getClass().getName())) {
                    results.add((S)component);
                }

                return true;
            }
        });

        return results;
    }

    public static <S extends UIComponent> List<S> findComponentsOfType(UIComponent baseComponent, final Class<S> clazz) {
        final List<S> results = new ArrayList<>();
        recurseChildren(baseComponent, 0, new UIComponentVisitor() {
            @Override
            public boolean visit(UIComponent component, int depth) {
                if (clazz.isInstance(component)) {
                    results.add((S)component);
                }

                return true;
            }
        });

        return results;
    }

    /**
     * Retrieve the first component in the baseComponent's structure that is
     * an instance of the passed in class.
     *
     * @param baseComponent
     * @param clazz
     * @param <S>
     * @return
     */
    public static <S extends UIComponent> S findFirstComponentOfType(UIComponent baseComponent, final Class<S> clazz) {
        final List<S> results = new ArrayList<>();
        recurseChildren(baseComponent, 0, new UIComponentVisitor() {
            @Override
            public boolean visit(UIComponent component, int depth) {

                if (clazz.isInstance(component)) {
                    results.add((S)component);
                    return false;
                }

                return true;
            }
        });

        // Return the first item in the list
        return (results.size() > 0 ? results.get(0) : null);
    }

    /**
     * Search for a component whose id matches the regular expression
     * @param baseComponent
     * @param regex
     * @param <S>
     * @return
     */
    public static <S extends UIComponent> S findFirstComponentByRegEx(UIComponent baseComponent, final String regex) {
        final List<S> results = new ArrayList<>();
        recurseChildren(baseComponent, 0, new UIComponentVisitor() {
            @Override
            public boolean visit(UIComponent component, int depth) {
                if (component.getId() != null && component.getId().matches(regex)) {
                    results.add((S)component);

                    // We found what we were looking for.
                    // Stop the search.
                    return false;
                }

                // Keep going
                return true;
            }
        });

        // Return the first item in the list
        return (results.size() > 0 ? results.get(0) : null);
    }

    /**
     * Recursively traverse the passed in component structure and call the passed in visitor.
     *
     * @param baseComponent
     * @param depth
     * @param visitor
     * @return
     */
    public static boolean recurseChildren(UIComponent baseComponent, int depth, UIComponentVisitor visitor) {
        if (visitor.visit(baseComponent, depth) == false) {
            // Abort
            return false;
        }

        if (baseComponent.getFacetsAndChildren() != null) {

            Iterator<UIComponent> childComponentIterator = baseComponent.getFacetsAndChildren();
            while (childComponentIterator.hasNext()) {
                UIComponent childComponent = childComponentIterator.next();
                if (recurseChildren(childComponent, depth + 1, visitor) == false) {
                    // Abort
                    return false;
                }
            }
        }

        // Keep going
        return true;
    }
}
