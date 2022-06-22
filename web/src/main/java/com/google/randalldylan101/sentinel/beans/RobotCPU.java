package com.google.randalldylan101.sentinel.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RobotCPU 
{
    private String model,serialNumber,category;
    private Date manufacturedDate;
}
