package com.google.randalldylan101.sentinel.beans;

import com.google.randalldylan101.sentinel.enums.RobotCPUEnum;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotCPU 
{
    private String model,serialNumber;
    private Date manufacturedDate;
    private RobotCPUEnum category;
}
