package com.GalvanizedGuardians.GuardianLib.Subsystems.Drive;

import java.io.File;
import java.io.IOException;

import com.GalvanizedGuardians.GuardianLib.Hardware.Gyros.GyroIO;
import com.ctre.phoenix6.CANBus;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

@SuppressWarnings({"java:S117", "java:S116"})
public class Drive extends SubsystemBase {
    protected final double ODOMETRY_FREQUENCY;

    private final GyroIO gyroIO;
    private final Module[] modules = new Module[4];

    
    public Drive(String TunerConstantsPath, GyroIO gyroIO, ModuleIO flModuleIO, ModuleIO frModuleIO, ModuleIO blModuleIO, ModuleIO brModuleIO) {
        TunerConstantsJson TunerConstants = loadConfigurationFromFile(TunerConstantsPath);

        ODOMETRY_FREQUENCY = new CANBus(TunerConstants.getDrivetrainConstants().CANBusName).isNetworkFD() ? 250.0 : 100.0;

        this.gyroIO = gyroIO;
        
        modules[0] = new Module(flModuleIO, 0, TunerConstants.getFrontLeft());
        modules[1] = new Module(frModuleIO, 1, TunerConstants.getFrontRight());
        modules[2] = new Module(blModuleIO, 2, TunerConstants.getBackLeft());
        modules[3] = new Module(brModuleIO, 3, TunerConstants.getBackRight());

        HAL.report(tResourceType.kResourceType_RobotDrive, tInstances.kRobotDriveSwerve_AdvantageKit);
    }

    public TunerConstantsJson loadConfigurationFromFile(String TunerConstantsPath) {
        File TunerConstantsFile = new File(TunerConstantsPath);
        assert TunerConstantsFile.exists();

        TunerConstantsJson TunerConstants = new TunerConstantsJson();

        try {
            TunerConstants = new ObjectMapper().readValue(TunerConstantsFile, TunerConstantsJson.class);
        } catch (IOException exception) {
            SmartDashboard.putString("TunerConstants: ", exception.getMessage());
        }

        return TunerConstants;
    }
}
