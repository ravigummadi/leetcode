package com.hackerrank;

/**
 * Created by Ravi on 10/9/2014.
 */
class RegexGenerator{

    IRepeaterFactory repFactory;
    IStringMatcherFactory matchFactory;

//    public RegexGenerator(IRepeaterFactory repeaterFactory, IStringMatcherFactory matcherFactory){
//        this.repFactory = repeaterFactory;
//        this.matchFactory = matcherFactory;
//    }
//
//    String  GetMatchingStringForRegex(String regex){
//        if(regex.isEmpty()) return "";
//        else return recursiveGeneratorForRegex(regex);
//    }
//
//
//    String recursiveGeneratorForRegex(String input){
//        String firstOccurance = GetFirstRegexPartOfString(input);
//        //if(String.is(input)) return input;
//        String matchPart = matchFactory.getStringMatcherFor(firstOccurance).getNextMatchedString(firstOccurance);
//        String repeatPart = repFactory.getRepeater(firstOccurance).getNextCombination(matchPart);
//        return  recursiveGeneratorForRegex(repeatPart);
//    }
//    // ---  Helper functions/interfaces
//
//    String GetFirstRegexPartOfString(String input){
//    }
//    String GenerateAPossibleCandidateForRegex(String regex){
//    }

}



// IRepeater provides an extensibile way to different type of repeaters to regex
// For example: +, *, ? etc.
interface IRepeater{
    /**
     * Given an input string they provide a repetation based on the repeater logic
     * @param input
     * @return
     */
    public String getNextCombination(String input);
}


interface IRepeaterFactory{
    public IRepeater getRepeater(String input);
    public void RegisterRepeater(String inputType, IRepeater repeater);
}

/**
 * Given a string
 */
interface IStringMatcher{
    String getNextMatchedString(String input);
}

interface IStringMatcherFactory{
    IStringMatcher getStringMatcherFor(String input);
    public void RegisterStringMatcher(String inputType, IRepeater repeater);
}

