package lt.vaidasbl.eshop.app.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface Attribute {
	public String name() default "";

}
