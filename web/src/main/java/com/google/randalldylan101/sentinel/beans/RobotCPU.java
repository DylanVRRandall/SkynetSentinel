package com.google.randalldylan101.sentinel.beans;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotCPU 
{
    private String model,serialNumber,category;
    private Date manufacturedDate;
}
