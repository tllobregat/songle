package com.qwicko.webservices.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.coreoz.plume.jersey.security.permission.PublicApi;

import com.qwicko.services.daily.DailyService;
import com.qwicko.webservices.api.data.GuessOption;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qwicko.services.configuration.ConfigurationService;
import com.qwicko.webservices.api.data.Daily;

import java.util.List;

@Path("/daily")
@Tag(name = "daily", description = "Manage daily web-services")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PublicApi
@Singleton
public class DailyWs {

	private final DailyService dailyService;

	@Inject
	public DailyWs(DailyService dailyService) {
		this.dailyService = dailyService;
	}

	@GET
	@Operation(description = "Get the daily song")
	public Daily getDailySong() {
		return dailyService.getDailySong();
	}

}
