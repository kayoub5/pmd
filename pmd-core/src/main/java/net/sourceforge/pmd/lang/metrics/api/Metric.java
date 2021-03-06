/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.metrics.api;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * Umbrella marker interface for metrics.
 *
 * @param <N> Type of nodes the metric can be computed on
 *
 * @author Clément Fournier
 */
public interface Metric<N extends Node> {


    /**
     * Checks if the metric can be computed on the node.
     *
     * @param node The node to check
     *
     * @return True if the metric can be computed
     */
    boolean supports(N node);


    /**
     * Actually computes the value of a metric for an AST node.
     *
     * @param node    The node
     * @param version The version of the metric
     *
     * @return The value of the metric, or {@code Double.NaN} if it could not be computed.
     */
    double computeFor(N node, MetricVersion version);


    /** Default metric versions. */
    enum Version implements MetricVersion {
        /** Standard option, used as a default. */
        STANDARD
    }

}
