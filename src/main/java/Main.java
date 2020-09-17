import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Main {
    public static void main(String[] args) {
        GpioController gpioController = GpioFactory.getInstance();
        final GpioPinDigitalOutput gpioPinDigitalOutput = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);
        final GpioPinDigitalInput gpioPinDigitalInput = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
        gpioPinDigitalInput.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpioPinDigitalStateChangeEvent) {
                gpioPinDigitalOutput.toggle();
            }
        });

    }
}