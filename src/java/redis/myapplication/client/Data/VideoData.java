package redis.myapplication.client.Data;

import redis.myapplication.main.models.Video;

public class VideoData {

    // Video names are made descriptive for readability purposes.

    public static final Video videoOnForce = Video.builder().language("English").title("Force").build();
    public static final Video videoOnLawsOfMotion = Video.builder().title("Laws of Motion").language("English").build();
    public static final Video videoOnOrganicChemistry = Video.builder().title("OrganicChemistry").language("English").build();
    public static final Video videoOnSolids = Video.builder().title("Solids").language("English").build();
    public static final Video videoOnAlgebra = Video.builder().title("Algebra").language("Hindi").build();
    public static final Video videoOnFractions = Video.builder().title("Fractions").language("Hindi").build();


}
