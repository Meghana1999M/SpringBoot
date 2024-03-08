package com.example.SpringBoot.api;
import com.example.SpringBoot.config.headers.MessageHeaders;
import com.example.SpringBoot.config.Valid;
import com.example.SpringBoot.domain.CreateEmployeeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.xml.sax.SAXException;
import java.io.IOException;
//import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
public interface EmployeeApi {
    @Operation(
            summary = "Create a new Employee.",
            description = "This endpoint is used to add a new Employee Details.")
    @Parameters(
            value = {
                    @Parameter(
                            name = MessageHeaders.MESSAGE_ID,
                            description = "message ID",
                            in = ParameterIn.HEADER,
                            schema = @Schema(implementation = String.class)),
                    @Parameter(
                            name = MessageHeaders.CORRELATION_ID,
                            description = "correlation ID",
                            in = ParameterIn.HEADER,
                            schema = @Schema(implementation = String.class)),
                    @Parameter(
                            name = MessageHeaders.COM_JWT,
                            description = "Authorization JWT Token generated by ISAM",
                            in = ParameterIn.HEADER,
                            schema = @Schema(implementation = String.class))
            })
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    ResponseEntity<String> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest)
            throws ParserConfigurationException, IOException, SAXException;
}
