package it.core;

import java.util.function.Supplier;

public class Supply implements Supplier<Ship> {

        @Override
        public Ship get(){

            return new Ship();
        }

}
