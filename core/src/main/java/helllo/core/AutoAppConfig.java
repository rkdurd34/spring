package helllo.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// @configuration 들어간것도 자동으로 스캔 되어버 @configuration 안에 이미 @comoponent가 있음
public class AutoAppConfig {


}
