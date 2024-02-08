package com.example.springwebmvcexample.model;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
	private Integer custId;
	private String custName;

}
