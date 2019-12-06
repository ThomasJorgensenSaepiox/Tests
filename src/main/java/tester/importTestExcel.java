package tester;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.TempFile;
import org.seleniumhq.jetty9.util.StringUtil;

import javax.print.DocFlavor;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.time.LocalDate;
/*
this does a minimalist import from an excel file into a list of objects, then verifies this against import into the page.

 */
public class importTestExcel {
    public static List<position> dash(File afile) throws IOException {
        List<position> positions = new LinkedList<position>();
        if (!afile.exists() || (!FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xlsx") && !FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xls"))) {
            System.out.println("yes, no, pull the other one, it has bells on it. this needs to be an excelsheet");
        } else {
            AtomicInteger i = new AtomicInteger(), j = new AtomicInteger();

            Workbook anImportofPositions = WorkbookFactory.create(afile);

            anImportofPositions.forEach(sheet -> {
                i.set(0);
                sheet.forEach(row -> {
                    i.getAndIncrement();
                    //       System.out.println(i.intValue());
                    j.set(-1);
                    position aposition = new position();
                    row.forEach(cell -> {
                        j.getAndIncrement();
                        if (i.intValue() > 1) {

                            switch (j.intValue()) {
                                case 0:

                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setName(cell.getStringCellValue());
                                    }
                                    break;

                                case 1:
                                    if (cell.getCellType() == CellType.NUMERIC) {

                                        aposition.setPortfolioId(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPortfolioId(cell.getStringCellValue());
                                    }
                                    break;
                                case 2:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPositionNominal(cell.getNumericCellValue());
                                        //               System.out.println(aposition.getPositionNominal()+"here");
                                    }
                                    break;
                                case 3:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setExposureCurrency(cell.getStringCellValue());
                                    }
                                    break;
                                case 4:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setExposureRatio(((byte) cell.getNumericCellValue()));
                                    }
                                    break;
                                default:

                            }

                        }
                        ;


                    });
                    if (!aposition.getPositionNominal().isNaN()) {
                        positions.add(aposition);
                    }
                    System.out.println("");

                });
                System.out.println(positions.size());
            });
        }
        return positions;
    }

    public static void maturityDateUpdatingForTestingDoNotUseOnProductionData(File afile) throws IOException {

        if (!afile.exists() || (!FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xlsx") && !FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xls"))) {
            System.out.println("yes, no, pull the other one, it has bells on it. this needs to be an excelsheet");
        } else {
            AtomicInteger i = new AtomicInteger(), j = new AtomicInteger(), u = new AtomicInteger();
            AtomicLong daysOffset = new AtomicLong(-3);
            AtomicBoolean d = new AtomicBoolean();
            FileInputStream dataImport= new FileInputStream(afile);
            Workbook anImportofPositions = WorkbookFactory.create(dataImport);
            FormulaEvaluator evaluator = anImportofPositions.getCreationHelper().createFormulaEvaluator();
            anImportofPositions.forEach(sheet -> {
                i.set(0);

                sheet.forEach(row -> {
                    i.getAndIncrement();
                    d.set(false);
                    row.forEach(cell -> {
                        if (i.get() == 1 && cell.getCellType() == CellType.STRING) {
                            if (cell.getStringCellValue().equalsIgnoreCase("maturity")) {
                                j.set(cell.getColumnIndex());
                            }
                            if (cell.getStringCellValue().equalsIgnoreCase("InstrumentType")||cell.getStringCellValue().equalsIgnoreCase("positiontype")) {
                                u.set(cell.getColumnIndex());
                                System.out.println("hedge ");
                            }}
                        if (i.get()>1){
                        if(cell.getColumnIndex()==u.get()){
                           if(cell.getStringCellValue().equalsIgnoreCase("hedge")){

                               d.set(true);
                           }}

                        }
                        if(cell.getColumnIndex()==j.get()&&d.get()) {
                            System.out.println(LocalDate.now());
                            System.out.println(LocalDate.now().plusDays(daysOffset.getAndIncrement()));
                            cell.setCellValue(LocalDate.now().plusDays(daysOffset.getAndIncrement()).toString());

                        }

                    });

                });
            });
            dataImport.close();
           FileOutputStream fileout = new FileOutputStream(afile);
            anImportofPositions.write(fileout);
            anImportofPositions.close();
            fileout.flush();
            fileout.close();
        }

    }
    public static File parseExcellFormulas(File afile) throws IOException {

        if (!afile.exists() || (!FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xlsx") && !FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xls"))) {
            System.out.println("yes, no, pull the other one, it has bells on it. this needs to be an excelsheet");
        } else {
            FileInputStream dataImport= new FileInputStream(afile);
            Workbook anImportofPositions = WorkbookFactory.create(dataImport);
            FormulaEvaluator evaluator = anImportofPositions.getCreationHelper().createFormulaEvaluator();
            anImportofPositions.forEach(sheet -> {


                sheet.forEach(row -> {

                    row.forEach(cell -> {
                            if(cell.getCellType()==CellType.FORMULA) {
                                if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                    String temporary = evaluator.evaluate(cell).getStringValue();
                                    cell.setCellValue(temporary);
                                } else if (evaluator.evaluate(cell).getCellType() == CellType.NUMERIC) {
                                    Double temp = evaluator.evaluate(cell).getNumberValue();
                                    cell.setCellValue(temp);
                                } else if (evaluator.evaluate(cell).getCellType() == CellType.BOOLEAN) {
                                    Boolean ephemeral = evaluator.evaluate(cell).getBooleanValue();
                                    cell.setCellValue(ephemeral);
                                } else if (evaluator.evaluate(cell).getCellType() == CellType.BLANK) {

                                } else if (evaluator.evaluate(cell).getCellType() == CellType.ERROR) {
                                    System.out.println("ERROR ENCOUNTERED. If you see this text, something is messed up");
                                }
                            }
                        });

                    });

                });

            dataImport.close();
            File myfile = TempFile.createTempFile("atestFile",".xlsx");
            FileOutputStream fileout = new FileOutputStream(myfile);
            anImportofPositions.write(fileout);
            anImportofPositions.close();
            fileout.flush();
            fileout.close();
            return myfile;
        }
return null;


    }
    public static List<position> positionstobeloaded_excell(File afile) throws IOException {
        List<position> positions = new LinkedList<position>();


        if (!afile.exists() || (!FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xlsx") && !FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xls"))) {
            System.out.println("yes, no, pull the other one, it has bells on it. this needs to be an excelsheet");
        } else {
            AtomicInteger i = new AtomicInteger(), j = new AtomicInteger();

            Workbook anImportofPositions = WorkbookFactory.create(afile);
            FormulaEvaluator evaluator = anImportofPositions.getCreationHelper().createFormulaEvaluator();
            anImportofPositions.forEach(sheet -> {
                i.set(0);
                sheet.forEach(row -> {
                    i.getAndIncrement();


                    position aposition = new position();

                    AtomicReference<Boolean> StrictlyRequired = new AtomicReference<Boolean>(true);
                    AtomicReference<Boolean> logicOr1 = new AtomicReference<Boolean>(true);
                    AtomicReference<Boolean> logicOr2 = new AtomicReference<Boolean>(true);

                    row.forEach(cell -> {
                        j.getAndIncrement();
                        if (i.intValue() > 1) {

                            switch (cell.getColumnIndex()) {
                                case 0:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPortfolioId(String.valueOf(cell.getNumericCellValue()));

                                    } else if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPortfolioId(cell.getStringCellValue());

                                    } else {
                                        StrictlyRequired.set(false);
                                        System.out.println("portfolioID not found in line" + i.get());

                                    }
                                    break;
                                case 1:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionId(cell.getStringCellValue());
                                    } else if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPositionId(String.valueOf(cell.getNumericCellValue()));
                                    } else {
                                        StrictlyRequired.set(false);
                                        System.out.println("positionid not found in line" + i.get());
                                    }
                                    break;
                                case 2:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionName(cell.getStringCellValue());
                                    }
                                    break;
                                case 3:

                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionGroup(cell.getStringCellValue());

                                    }
                                    if (cell.getCellType() == CellType.FORMULA) {
                                        if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                            aposition.setPositionGroup(evaluator.evaluate(cell).getStringValue());
                                        }
                                    }
                                    break;
                                case 4:

                                    if (cell.getCellType() == CellType.STRING) {

                                        aposition.setPositionType(cell.getStringCellValue());
                                    }
                                    break;
                                case 5:
                                    if (cell.getCellType() == CellType.STRING) {

                                        aposition.setMaturity(cell.getStringCellValue());
                                    } else if (cell.getCellType() == CellType.BLANK) {
                                        aposition.setMaturity("99991212");
                                    } else if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setMaturity(String.valueOf(cell.getNumericCellValue()));
                                    }

                                    break;
                                case 6:

                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setAllocation(cell.getStringCellValue());
                                    }

                                    break;
                                case 7:

                                    if (cell.getCellType() == CellType.STRING) {

                                        aposition.setExposureCurrency(cell.getStringCellValue());
                                    }
                                    if (cell.getCellType() == CellType.FORMULA) {
                                        if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                            aposition.setExposureCurrency(evaluator.evaluate(cell).getStringValue());
                                        }
                                    }
                                    break;
                                case 8:

                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPositionNominal(cell.getNumericCellValue());

                                    } else if (cell.getCellType() == CellType.STRING) {

                                        aposition.setPositionNominal(Double.valueOf(removingDoubleQuotations(cell.getStringCellValue())));
                                    } else {
                                        logicOr1.set(false);
                                    }
                                    break;
                                case 9:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setWeightedExposureValueExpCCY(cell.getStringCellValue());

                                    } else if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setWeightedExposureValueExpCCY(String.valueOf(cell.getNumericCellValue()));

                                    } else if (cell.getCellType() == CellType.FORMULA) {
                                        if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                            aposition.setWeightedExposureValueExpCCY(evaluator.evaluate(cell).getStringValue());

                                        } else {
                                            aposition.setWeightedExposureValueExpCCY(String.valueOf(evaluator.evaluate(cell).getNumberValue()));


                                        }
                                    } else {
                                        logicOr2.set(false);
                                    }

                                    break;
                                case 11:

                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setBasCurrency(cell.getStringCellValue());
                                    }

                                    if (cell.getCellType() == CellType.FORMULA) {
                                        if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                            aposition.setBasCurrency(evaluator.evaluate(cell).getStringValue());
                                        } else if (evaluator.evaluate(cell).getCellType() == CellType.NUMERIC) {
                                            aposition.setBasCurrency(String.valueOf(evaluator.evaluate(cell).getNumberValue()));
                                        }


                                    }
                                    break;


                                case 12:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setExpBas(cell.getStringCellValue());
                                    }
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setExpBas(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    if (cell.getCellType() == CellType.FORMULA) {
                                        if (evaluator.evaluate(cell).getCellType() == CellType.STRING) {
                                            aposition.setExpBas(evaluator.evaluate(cell).getStringValue());
                                        } else if (evaluator.evaluate(cell).getCellType() == CellType.NUMERIC) {
                                            aposition.setExpBas(String.valueOf(evaluator.evaluate(cell).getNumberValue()));
                                        }

                                    }

                                    break;
                                case 13:

                                    if (cell.getCellType() == CellType.STRING) {

                                        aposition.setPriceDate(cell.getStringCellValue());
                                    }
                                    break;
                                default:

                            }

                        }
                        ;


                    });
                    if (StrictlyRequired.get() && (logicOr1.get() || logicOr2.get())) {
                        positions.add(aposition);
                    } else {
                        System.out.println("line:" + i.get() + "does not contain a minimally coherent position. ");
                    }


                });
                //               System.out.println(positions.size());
            });
        }
        return positions;
    }

    public static void readFile(File afile) throws IOException {
        Map<Integer, String> stringMap = null;
        List<position> positions = new LinkedList<position>();
        if (!afile.exists() || (!FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xlsx") && !FilenameUtils.getExtension(afile.getAbsolutePath()).equalsIgnoreCase("xls"))) {
            System.out.println("yes, no, pull the other one, it has bells on it. this needs to be an excelsheet");
        } else {
            AtomicInteger i = new AtomicInteger(), j = new AtomicInteger();

            Workbook anImportofPositions = WorkbookFactory.create(afile);

            anImportofPositions.forEach(sheet -> {
                i.set(0);
                sheet.forEach(row -> {
                    i.getAndIncrement();
                    System.out.println(i.intValue());
                    j.set(-1);
                    position aposition = new position();
                    row.forEach(cell -> {
                        j.getAndIncrement();
                        if (i.intValue() > 2) {

                            switch (j.intValue()) {
                                case 0:

                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPortfolioId(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPortfolioId(cell.getStringCellValue());
                                    }
                                    break;

                                case 1:
                                    if (cell.getCellType() == CellType.STRING) {

                                        aposition.setPositionId((cell.getStringCellValue()));
                                    }
                                    break;
                                case 3:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionName(cell.getStringCellValue());

                                    }
                                    break;
                                case 4:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPositionNominal(cell.getNumericCellValue());
                                    }
                                    break;
                                case 5:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setExposureRatio(((byte) cell.getNumericCellValue()));
                                    }
                                    break;
                                case 6:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionGroup(cell.getStringCellValue());
                                    }
                                    break;
                                case 7:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPositionType(cell.getStringCellValue());
                                    }
                                    break;
                                case 8:
                                    if (cell.getCellType() == CellType.STRING) {
                                    }
                                    break;
                                case 9:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setLegNo(cell.getStringCellValue());
                                    }
                                    break;
                                case 10:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setAllocation(cell.getStringCellValue());
                                    }
                                    break;
                                case 11:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setExposureCurrency(cell.getStringCellValue());
                                    }
                                    break;
                                case 12:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setCalcWeight(cell.getNumericCellValue());
                                    }
                                    break;
                                case 13:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPfDepth(((int) cell.getNumericCellValue()));
                                    }
                                    break;
                                case 14:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setWeightedMarketValueExpCCY(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                case 15:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        // aposition.setWeightedExposureValueExpCCY(String.valueOf(cell.getNumericCellValue()));
                                    }
                                    break;
                                case 16:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setName(cell.getStringCellValue());
                                    }
                                    break;
                                case 17:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setBasCurrency(cell.getStringCellValue());
                                    }

                                    break;
                                case 18:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setParent((byte) cell.getNumericCellValue());
                                    }
                                    break;
                                case 19:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setExpCcyPair(cell.getStringCellValue());
                                    }
                                    break;
                                case 20:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setExpCcyRate((float) cell.getNumericCellValue());
                                    }
                                    break;
                                case 21:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setPrice((float) cell.getNumericCellValue());
                                    }
                                    break;
                                case 22:
                                    if (cell.getCellType() == CellType.STRING) {
                                        aposition.setPriceDate(correctingDateFormat(cell.getStringCellValue()));
                                    }
                                    break;
                                case 23:
                                    if (cell.getCellType() == CellType.NUMERIC) {
                                        aposition.setIsReportingDay(correctingDateFormat(String.valueOf(cell.getNumericCellValue())));
                                    }
                                    break;
                                case 24:
                                    if (cell.getCellType() == CellType.NUMERIC) {

                                        aposition.setHedgeable(String.valueOf(cell.getNumericCellValue()));
                                    }
                                default:

                            }
                        }
                        ;


                    });
                    System.out.println("");
                    positions.add(aposition);
                });
                System.out.println(positions.size());
            });
        }
    }

    private static String removingDoubleQuotations(String aNumber3) {
        return aNumber3.replaceAll("\"", "").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");

    }


    private static String correctingDateFormat(String aNumber5) {

        if (aNumber5.length() < 10) {
            return "9999-11-11";
        } else if (StringUtil.isBlank(aNumber5.substring(1, 2))) {
            return "9999-11-11";


        } else {
            return aNumber5.substring(7, 11) + "-" + aNumber5.substring(4, 6) + "-" + aNumber5.substring(1, 3).replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");


        }
    }

}
