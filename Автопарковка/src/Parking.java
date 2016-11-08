/**
 * Created by Emil on 08.11.2016.
 */
public class Parking {
    private Transport[] deviceList;

    public Parking() {
        this.deviceList = new Transport[0];
    }

    public int getDeviceListCount() {
        return deviceList.length;
    }

    public void AddDevice(Transport newdevice) {
        Transport[] newDeviceList = new Transport[deviceList.length+1];
        for (int i = 0; i < deviceList.length; i++) {
            newDeviceList[i] = deviceList[i];
        }
        newDeviceList[deviceList.length] = newdevice;
        newdevice.index = deviceList.length;
        System.out.println("Добавлено новое траснпортное средство: " + newdevice.deviceType);
        deviceList = newDeviceList;
    }

    public void DellDevice(Transport olddevice) {
        Transport[] newDeviceList = new Transport[deviceList.length-1];
        for (int i = 0; i < olddevice.index; i++) {
            newDeviceList[i] = deviceList[i];
        }
        for (int i = olddevice.index+1; i < deviceList.length; i++) {
            newDeviceList[i-1] = deviceList[i];
        }
        System.out.println("Удалено траснпортное средство: " + olddevice.deviceType);
        deviceList = newDeviceList;
    }

    public void AllDevicesMove() {
        if (deviceList.length > 0) {
            for (int i = 0; i < deviceList.length; i++) {
                deviceList[i].Move();
            }
        }
    }

}
