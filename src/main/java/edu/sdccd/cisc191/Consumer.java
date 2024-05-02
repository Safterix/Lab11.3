package edu.sdccd.cisc191;

/**
 * Consumers receive a number of Items from a Warehouse
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Consumer extends Thread
{
    private String name;
    private Warehouse warehouse;
    private int numberOfItemsToConsume;

    public Consumer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToConsume)
    {
        name = givenName;
        warehouse = givenWarehouse;
        numberOfItemsToConsume = givenNumberOfItemsToConsume;
    }

    @Override
    public void run()
    {
        System.out.println(name + " running in Thread: " + Thread.currentThread().getName());

        for (int i=0; i<numberOfItemsToConsume; i++) {
            try {
                warehouse.ship();
            } catch (OutOfStockException e) {
                System.out.println("Out of stock, cannot consume.");
            }
        }


        System.out.println(name + " ended.");
    }

}