package com.piestack.crypto.di.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jeffrey Nyauke on 9/10/2017.
 */

@Scope
@Retention(value= RetentionPolicy.RUNTIME)
public @interface RateScope {
}
