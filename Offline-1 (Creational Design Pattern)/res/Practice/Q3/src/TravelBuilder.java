import java.util.Scanner;

class Vacation
{
    private String hotel;
    private String car;
    private String activity;

    public void setHotel(String hotel)
    {
        this.hotel = hotel;
    }

    public void setCar(String car)
    {
        this.car = car;
    }

    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    public void showVacation()
    {
        System.out.println("Hotel: " + hotel);
        System.out.println("Car: " + car);
        System.out.println("Activity: " + activity);
    }
}

interface TravelBuilderinterface
{
    public void setHotel();
    public void setCar();
    public void setActivity();
    public Vacation getVacation();
}

class BeachVacationBuilder implements TravelBuilderinterface
{
    private Vacation vacation = new Vacation();

    @Override
    public void setHotel()
    {
        vacation.setHotel("Beach Resort");
    }

    @Override
    public void setCar()
    {
        vacation.setCar("Convertible");
    }

    @Override
    public void setActivity()
    {
        vacation.setActivity("Snorkeling");
    }

    @Override
    public Vacation getVacation()
    {
        return vacation;
    }
}

class MountainVacationBuilder implements TravelBuilderinterface
{
    private Vacation vacation = new Vacation();

    @Override
    public void setHotel()
    {
        vacation.setHotel("Mountain Resort");
    }

    @Override
    public void setCar()
    {
        vacation.setCar("SUV");
    }

    @Override
    public void setActivity()
    {
        vacation.setActivity("Hiking");
    }

    @Override
    public Vacation getVacation()
    {
        return vacation;
    }
}

class LuxuryVacationBuilder implements TravelBuilderinterface
{
    private Vacation vacation = new Vacation();

    @Override
    public void setHotel()
    {
        vacation.setHotel("5-Star Hotel");
    }

    @Override
    public void setCar()
    {
        vacation.setCar("Limo");
    }

    @Override
    public void setActivity()
    {
        vacation.setActivity("Helicopter Tour");
    }

    @Override
    public Vacation getVacation()
    {
        return vacation;
    }
}

class VacationDirector
{
    public static Vacation buildVacation(TravelBuilderinterface builder)
    {
        builder.setHotel();
        builder.setCar();
        builder.setActivity();
        return builder.getVacation();
    }
}

public class TravelBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Our Plans:");
        System.out.println("1. Beach Vacation");
        System.out.println("2. Mountain Vacation");
        System.out.println("3. Luxury Vacation");
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine();
        TravelBuilderinterface builder;
        Vacation vacation;
        if(choice.equalsIgnoreCase("BEACH"))
        {
            builder = new BeachVacationBuilder();
            vacation = VacationDirector.buildVacation(builder);
        }
        else if(choice.equalsIgnoreCase("MOUNTAIN"))
        {
            builder = new MountainVacationBuilder();
            vacation = VacationDirector.buildVacation(builder);
        }
        else if(choice.equalsIgnoreCase("LUXURY"))
        {
            builder = new LuxuryVacationBuilder();
            vacation = VacationDirector.buildVacation(builder);
        }
        else
        {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        vacation.showVacation();
        
        sc.close();
    }
}
