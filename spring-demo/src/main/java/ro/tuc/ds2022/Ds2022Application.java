package ro.tuc.ds2022;

import grpc.service.ChatServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.TimeZone;

@SpringBootApplication
@Validated
@EnableScheduling
public class Ds2022Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Ds2022Application.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Ds2022Application.class, args);

        final int PORT = 9090;
        Server server = ServerBuilder.forPort(PORT)
                .addService(new ChatServiceImpl())
                .build();
        server.start();
        System.out.println("Server started...");
        server.awaitTermination();
    }
}
