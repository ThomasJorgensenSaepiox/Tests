package tester;

import org.apache.commons.lang3.StringUtils;

public class position {
    private double PortfolioId;
    private String PositionId;
    private String PositionName;
    private Double PositionNominal = Double.NaN;
    private Byte ExposureRatio = Byte.MIN_VALUE;
    private String PositionGroup;
    private String PositionType;
    private String Maturity;
    private String LegNo;
    private String Allocation;
    private String ExposureCurrency;
    private double CalcWeight;
    private Integer PfDepth = Integer.MIN_VALUE;
    private String WeightedMarketValueExpCCY;
    private String WeightedExposureValueExpCCY;
    private String Name;
    private String BasCurrency;
    private Byte Parent = Byte.MIN_VALUE;
    private String PfCCYPair;
    private Float PfCcyRate = Float.NaN;
    private String ExpBas;
    private String ExpCcyPair;
    private Float ExpCcyRate = Float.NaN;
    private Float Price = Float.NaN;
    private String PriceDate;
    private String IsReportingDay;
    private String Hedgeable;


    public double getPortfolioId() {
        return PortfolioId;
    }

    public void setPortfolioId(double portfolioId) {
        PortfolioId = portfolioId;
    }

    public String getPositionId() {
        return PositionId;
    }

    public void setPositionId(String positionId) {
        PositionId = positionId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public Double getPositionNominal() {
        return PositionNominal;
    }

    public void setPositionNominal(Double positionNominal) {
        PositionNominal = positionNominal;
    }

    public Byte getExposureRatio() {
        return ExposureRatio;
    }

    public void setExposureRatio(Byte exposureRatio) {
        ExposureRatio = exposureRatio;
    }

    public String getPositionGroup() {
        return PositionGroup;
    }

    public void setPositionGroup(String positionGroup) {


    }

    public String getPositionType() {
        return PositionType;
    }

    public void setPositionType(String positionType) {
        if (!StringUtils.isBlank(positionType)) {
            PositionType = positionType;
        }
    }

    public String getMaturity() {
        return Maturity;
    }

    public void setMaturity(String maturity) {
        if (!maturity.equalsIgnoreCase("9999-11-11")) {
            Maturity = maturity;
        }
    }

    public String getLegNo() {
        return LegNo;
    }

    public void setLegNo(String legNo) {
        if (!StringUtils.isBlank(legNo)) {
            LegNo = legNo;
        }

    }

    public String getAllocation() {
        return Allocation;
    }

    public void setAllocation(String allocation) {
        if (!StringUtils.isBlank(allocation)) {
            Allocation = allocation;
        }

    }

    public String getExposureCurrency() {
        return ExposureCurrency;
    }

    public void setExposureCurrency(String exposureCurrency) {
        if (!StringUtils.isBlank(exposureCurrency)) {
            ExposureCurrency = exposureCurrency;
        }

    }

    public Integer getPfDepth() {
        return PfDepth;
    }

    public void setPfDepth(Integer pfDepth) {
        PfDepth = pfDepth;
    }

    public double getCalcWeight() {

        return CalcWeight;
    }

    public void setCalcWeight(double calcWeight) {
            CalcWeight = calcWeight;


    }

    public String getWeightedMarketValueExpCCY() {
        return WeightedMarketValueExpCCY;
    }

    public void setWeightedMarketValueExpCCY(String weightedMarketValueExpCCY) {
        if (!StringUtils.isBlank(weightedMarketValueExpCCY)) {
            WeightedMarketValueExpCCY = weightedMarketValueExpCCY;
        }

    }

    public String getWeightedExposureValueExpCCY() {
        return WeightedExposureValueExpCCY;
    }

    public void setWeightedExposureValueExpCCY(String weightedExposureValueExpCCY) {
        if (!StringUtils.isBlank(weightedExposureValueExpCCY)) {
            WeightedExposureValueExpCCY = weightedExposureValueExpCCY;
        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (!StringUtils.isBlank(name)) {
            Name = name;
        }

    }

    public String getBasCurrency() {
        return BasCurrency;
    }

    public void setBasCurrency(String basCurrency) {
        if (!StringUtils.isBlank(basCurrency)) {
            BasCurrency = basCurrency;
        }

    }

    public Byte getParent() {
        return Parent;
    }

    public void setParent(Byte parent) {

        Parent = parent;
    }

    public String getPfCCYPair() {
        return PfCCYPair;
    }

    public void setPfCCYPair(String pfCCYPair) {
        if (!StringUtils.isBlank(pfCCYPair)) {
            PfCCYPair = pfCCYPair;
        }

    }

    public String getExpBas() {
        return ExpBas;
    }

    public void setExpBas(String expBas) {
        if (!StringUtils.isBlank(expBas)) {
            ExpBas = expBas;
        }

    }

    public Float getPfCcyRate() {
        return PfCcyRate;
    }

    public void setPfCcyRate(Float pfCcyRate) {

        PfCcyRate = pfCcyRate;


    }

    public Float getExpCcyRate() {

        return ExpCcyRate;
    }

    public void setExpCcyRate(Float expCcyRate) {
        ExpCcyRate = expCcyRate;
    }

    public String getExpCcyPair() {
        return ExpCcyPair;
    }

    public void setExpCcyPair(String expCcyPair) {
        if (!StringUtils.isBlank(expCcyPair)) {
            ExpCcyPair = expCcyPair;
        }

    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getPriceDate() {
        return PriceDate;
    }

    public void setPriceDate(String priceDate) {
        if (!StringUtils.isBlank(priceDate)) {
            PriceDate = priceDate;
        }

    }

    public String getIsReportingDay() {
        return IsReportingDay;
    }

    public void setIsReportingDay(String isReportingDay) {
        if (!StringUtils.isBlank(isReportingDay)) {
            IsReportingDay = isReportingDay;
        }

    }

    public String getHedgeable() {
        return Hedgeable;
    }

    public void setHedgeable(String hedgeable) {
        if (!StringUtils.isBlank(hedgeable)) {
            Hedgeable = hedgeable;
        }

    }

}
