import java.text.DecimalFormat;
//Clase que contiene metodo para convertir monedas, solicitar e imprimir informacion al usuario
public class Convertidor {
    //variables
    double moneda1 = 0;
    double moneda2 = 0;

    ConexionApi conexionAPI = new ConexionApi();
    JsonClass jsonToClass = conexionAPI.consultarApi();

    //metodo para solicitar cantidad al usuario
    public void imprimirSolicitarCantidad(String monedaOrigen, String monedaDestino){
        System.out.println("""
                            ==============================================
                            """ +monedaOrigen + """ 
                            \s ==> \s""" +monedaDestino +"""
                            \nIngresa el valor que deseas convertir: 
                            """);
    }

    //metodo para conversion entre monedas
    public double convertirMonedas(String monedaOrigen, String monedaDestino, double cantidad) {
        moneda1 = jsonToClass.conversion_rates().get(monedaDestino); //
        moneda2 = jsonToClass.conversion_rates().get(monedaOrigen); //
        return (moneda1/moneda2)*cantidad;
    }

    //metodo para imprimir resultado de conversion
    public void imprimirResultado(double cantidad, String monedaOrigen, double convertir, String monedaDestino){
        DecimalFormat df = new DecimalFormat(); //Instancia de DecimalFormat para formatear el double "convertir" a 2 decimales
        System.out.println(cantidad +" " +monedaOrigen + " = " +df.format(convertir) +" " +monedaDestino);
        System.out.println("==============================================\n");
    }

    //metodo para imprimir codigos ISO de monedas
    public void imprimirCodigoMonedas(){
        System.out.println("""
                Codigo Moneda 	 Nombre Moneda 	 Pais
                AED 	 UAE Dirham 	 United Arab Emirates\s
                AFN 	 Afghan Afghani 	 Afghanistan\s
                ALL 	 Albanian Lek 	 Albania\s
                AMD 	 Armenian Dram 	 Armenia\s
                ANG 	 Netherlands Antillian Guilder 	 Netherlands Antilles\s
                AOA 	 Angolan Kwanza 	 Angola\s
                ARS 	 Argentine Peso 	 Argentina\s
                AUD 	 Australian Dollar 	 Australia\s
                AWG 	 Aruban Florin 	 Aruba\s
                AZN 	 Azerbaijani Manat 	 Azerbaijan\s
                BAM 	 Bosnia and Herzegovina Mark 	 Bosnia and Herzegovina\s
                BBD 	 Barbados Dollar 	 Barbados\s
                BDT 	 Bangladeshi Taka 	 Bangladesh\s
                BGN 	 Bulgarian Lev 	 Bulgaria\s
                BHD 	 Bahraini Dinar 	 Bahrain\s
                BIF 	 Burundian Franc 	 Burundi\s
                BMD 	 Bermudian Dollar 	 Bermuda\s
                BND 	 Brunei Dollar 	 Brunei\s
                BOB 	 Bolivian Boliviano 	 Bolivia\s
                BRL 	 Brazilian Real 	 Brazil\s
                BSD 	 Bahamian Dollar 	 Bahamas\s
                BTN 	 Bhutanese Ngultrum 	 Bhutan\s
                BWP 	 Botswana Pula 	 Botswana\s
                BYN 	 Belarusian Ruble 	 Belarus\s
                BZD 	 Belize Dollar 	 Belize\s
                CAD 	 Canadian Dollar 	 Canada\s
                CDF 	 Congolese Franc 	 Democratic Republic of the Congo\s
                CHF 	 Swiss Franc 	 Switzerland\s
                CLP 	 Chilean Peso 	 Chile\s
                CNY 	 Chinese Renminbi 	 China\s
                COP 	 Colombian Peso 	 Colombia\s
                CRC 	 Costa Rican Colon 	 Costa Rica\s
                CUP 	 Cuban Peso 	 Cuba\s
                CVE 	 Cape Verdean Escudo 	 Cape Verde\s
                CZK 	 Czech Koruna 	 Czech Republic\s
                DJF 	 Djiboutian Franc 	 Djibouti\s
                DKK 	 Danish Krone 	 Denmark\s
                DOP 	 Dominican Peso 	 Dominican Republic\s
                DZD 	 Algerian Dinar 	 Algeria\s
                EGP 	 Egyptian Pound 	 Egypt\s
                ERN 	 Eritrean Nakfa 	 Eritrea\s
                ETB 	 Ethiopian Birr 	 Ethiopia\s
                EUR 	 Euro 	 European Union\s
                FJD 	 Fiji Dollar 	 Fiji\s
                FKP 	 Falkland Islands Pound 	 Falkland Islands\s
                FOK 	 Faroese Króna 	 Faroe Islands\s
                GBP 	 Pound Sterling 	 United Kingdom\s
                GEL 	 Georgian Lari 	 Georgia\s
                GGP 	 Guernsey Pound 	 Guernsey\s
                GHS 	 Ghanaian Cedi 	 Ghana\s
                GIP 	 Gibraltar Pound 	 Gibraltar\s
                GMD 	 Gambian Dalasi 	 The Gambia\s
                GNF 	 Guinean Franc 	 Guinea\s
                GTQ 	 Guatemalan Quetzal 	 Guatemala\s
                GYD 	 Guyanese Dollar 	 Guyana\s
                HKD 	 Hong Kong Dollar 	 Hong Kong\s
                HNL 	 Honduran Lempira 	 Honduras\s
                HRK 	 Croatian Kuna 	 Croatia\s
                HTG 	 Haitian Gourde 	 Haiti\s
                HUF 	 Hungarian Forint 	 Hungary\s
                IDR 	 Indonesian Rupiah 	 Indonesia\s
                ILS 	 Israeli New Shekel 	 Israel\s
                IMP 	 Manx Pound 	 Isle of Man\s
                INR 	 Indian Rupee 	 India\s
                IQD 	 Iraqi Dinar 	 Iraq\s
                IRR 	 Iranian Rial 	 Iran\s
                ISK 	 Icelandic Króna 	 Iceland\s
                JEP 	 Jersey Pound 	 Jersey\s
                JMD 	 Jamaican Dollar 	 Jamaica\s
                JOD 	 Jordanian Dinar 	 Jordan\s
                JPY 	 Japanese Yen 	 Japan\s
                KES 	 Kenyan Shilling 	 Kenya\s
                KGS 	 Kyrgyzstani Som 	 Kyrgyzstan\s
                KHR 	 Cambodian Riel 	 Cambodia\s
                KID 	 Kiribati Dollar 	 Kiribati\s
                KMF 	 Comorian Franc 	 Comoros\s
                KRW 	 South Korean Won 	 South Korea\s
                KWD 	 Kuwaiti Dinar 	 Kuwait\s
                KYD 	 Cayman Islands Dollar 	 Cayman Islands\s
                KZT 	 Kazakhstani Tenge 	 Kazakhstan\s
                LAK 	 Lao Kip 	 Laos\s
                LBP 	 Lebanese Pound 	 Lebanon\s
                LKR 	 Sri Lanka Rupee 	 Sri Lanka\s
                LRD 	 Liberian Dollar 	 Liberia\s
                LSL 	 Lesotho Loti 	 Lesotho\s
                LYD 	 Libyan Dinar 	 Libya\s
                MAD 	 Moroccan Dirham 	 Morocco\s
                MDL 	 Moldovan Leu 	 Moldova\s
                MGA 	 Malagasy Ariary 	 Madagascar\s
                MKD 	 Macedonian Denar 	 North Macedonia\s
                MMK 	 Burmese Kyat 	 Myanmar\s
                MNT 	 Mongolian Tögrög 	 Mongolia\s
                MOP 	 Macanese Pataca 	 Macau\s
                MRU 	 Mauritanian Ouguiya 	 Mauritania\s
                MUR 	 Mauritian Rupee 	 Mauritius\s
                MVR 	 Maldivian Rufiyaa 	 Maldives\s
                MWK 	 Malawian Kwacha 	 Malawi\s
                MXN 	 Mexican Peso 	 Mexico\s
                MYR 	 Malaysian Ringgit 	 Malaysia\s
                MZN 	 Mozambican Metical 	 Mozambique\s
                NAD 	 Namibian Dollar 	 Namibia\s
                NGN 	 Nigerian Naira 	 Nigeria\s
                NIO 	 Nicaraguan Córdoba 	 Nicaragua\s
                NOK 	 Norwegian Krone 	 Norway\s
                NPR 	 Nepalese Rupee 	 Nepal\s
                NZD 	 New Zealand Dollar 	 New Zealand\s
                OMR 	 Omani Rial 	 Oman\s
                PAB 	 Panamanian Balboa 	 Panama\s
                PEN 	 Peruvian Sol 	 Peru\s
                PGK 	 Papua New Guinean Kina 	 Papua New Guinea\s
                PHP 	 Philippine Peso 	 Philippines\s
                PKR 	 Pakistani Rupee 	 Pakistan\s
                PLN 	 Polish Złoty 	 Poland\s
                PYG 	 Paraguayan Guaraní 	 Paraguay\s
                QAR 	 Qatari Riyal 	 Qatar\s
                RON 	 Romanian Leu 	 Romania\s
                RSD 	 Serbian Dinar 	 Serbia\s
                RUB 	 Russian Ruble 	 Russia\s
                RWF 	 Rwandan Franc 	 Rwanda\s
                SAR 	 Saudi Riyal 	 Saudi Arabia\s
                SBD 	 Solomon Islands Dollar 	 Solomon Islands\s
                SCR 	 Seychellois Rupee 	 Seychelles\s
                SDG 	 Sudanese Pound 	 Sudan\s
                SEK 	 Swedish Krona 	 Sweden\s
                SGD 	 Singapore Dollar 	 Singapore\s
                SHP 	 Saint Helena Pound 	 Saint Helena\s
                SLE 	 Sierra Leonean Leone 	 Sierra Leone\s
                SOS 	 Somali Shilling 	 Somalia\s
                SRD 	 Surinamese Dollar 	 Suriname\s
                SSP 	 South Sudanese Pound 	 South Sudan\s
                STN 	 São Tomé and Príncipe Dobra 	 São Tomé and Príncipe\s
                SYP 	 Syrian Pound 	 Syria\s
                SZL 	 Eswatini Lilangeni 	 Eswatini\s
                THB 	 Thai Baht 	 Thailand\s
                TJS 	 Tajikistani Somoni 	 Tajikistan\s
                TMT 	 Turkmenistan Manat 	 Turkmenistan\s
                TND 	 Tunisian Dinar 	 Tunisia\s
                TOP 	 Tongan Paʻanga 	 Tonga\s
                TRY 	 Turkish Lira 	 Turkey\s
                TTD 	 Trinidad and Tobago Dollar 	 Trinidad and Tobago\s
                TVD 	 Tuvaluan Dollar 	 Tuvalu\s
                TWD 	 New Taiwan Dollar 	 Taiwan\s
                TZS 	 Tanzanian Shilling 	 Tanzania\s
                UAH 	 Ukrainian Hryvnia 	 Ukraine\s
                UGX 	 Ugandan Shilling 	 Uganda\s
                USD 	 United States Dollar 	 United States\s
                UYU 	 Uruguayan Peso 	 Uruguay\s
                UZS 	 Uzbekistani So'm 	 Uzbekistan\s
                VES 	 Venezuelan Bolívar Soberano 	 Venezuela\s
                VND 	 Vietnamese Đồng 	 Vietnam\s
                VUV 	 Vanuatu Vatu 	 Vanuatu\s
                WST 	 Samoan Tālā 	 Samoa\s
                XAF 	 Central African CFA Franc 	 CEMAC\s
                XCD 	 East Caribbean Dollar 	 Organisation of Eastern Caribbean States\s
                XDR 	 Special Drawing Rights 	 International Monetary Fund\s
                XOF 	 West African CFA franc 	 CFA\s
                XPF 	 CFP Franc 	 Collectivités d'Outre Mer\s
                YER 	 Yemeni Rial 	 Yemen\s
                ZAR 	 South African Rand 	 South Africa\s
                ZMW 	 Zambian Kwacha 	 Zambia\s
                ZWL 	 Zimbabwean Dollar 	 Zimbabwe);
                """);
    }
}
