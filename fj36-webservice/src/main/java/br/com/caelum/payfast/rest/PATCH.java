package br.com.caelum.payfast.rest;

import javax.ws.rs.HttpMethod;
import java.lang.annotation.*;

/**
 * Created by danilo on 05/03/16.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
@Documented
public @interface PATCH {
}
