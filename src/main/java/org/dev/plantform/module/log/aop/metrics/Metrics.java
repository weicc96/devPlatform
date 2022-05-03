
package org.dev.plantform.module.log.aop.metrics;

import java.lang.annotation.*;

/**
 * @author weichenchen
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Metrics {

}
