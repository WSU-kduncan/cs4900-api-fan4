package com.Fan4.Collectiviews.demo.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class WatchedMovieDto {

  String user;

  Integer movieID;

  LocalDate watchedDate;
}