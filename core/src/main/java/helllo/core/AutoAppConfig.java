package helllo.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", <- 탐색 위치 지정 가능 {"hello.core", "hello.service"} 도가능
//        basePackageClasses = AutoAppConfig.class   <- 1번째줄의 패키지 위치를 다 확인해보도록 디폴트 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// @configuration 들어간것도 자동으로 스캔 되어버 @configuration 안에 이미 @comoponent가 있음
public class AutoAppConfig {


}
