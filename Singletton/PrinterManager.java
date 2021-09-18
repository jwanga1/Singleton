public class PrinterManager{
  private static PrinterManager instance;
  
  // private constructor
  private PrinterManager(int numPrinter) {
    Printer[] printers = new Printer[numPrinter];
    // initialize them
    for (int i = 0; i < numPrinter ; i++) {
      printers[i] = new Printer();
    }
  }
  
  // important method of returning singleton instance
  public static PrinterManager getInstance() {
    // no existing instance
    // create a new one
    if (instance == null)
      instance = new PrinterManager(8);
    // if there is one exists
    // just return it.
    return instance;
  }

  public void showStatus()
  {
    for (int i = 0; i < printers.length; i++) {
      System.out.println("Status of Printer "+i+":");
      if(printers[i].isBusy)
      {
        System.out.println("Busy");
      }else
        System.out.println("Available");
    }
  }

  // assign a job to printer
  public String assignJob(String printJob) {
    // check available printers
    for (Printer printer : printers) {
      if (printer.isBusy() == false) {
        printer.setBusy(true);
        printer.setPrintJob(printJob);
        return "job is assigned.";
      }
    }
    // no available printers
    return "all printers are busy, please try again later.";
  }

}