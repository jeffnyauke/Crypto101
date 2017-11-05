package com.piestack.crypto.di.qualifiers;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jeffrey Nyauke on 9/10/2017.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ActivityContext {
    String value() default "";
}
