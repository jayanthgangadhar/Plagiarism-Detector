import sys
class OptimalPartition:
    """
    Class to partition the items into at most N
    non­overlapping, consecutive bins, in a way that minimizes the maximum
    number of items in any bin.
    """
    def __init__(self, filename = "../data/input.txt"):
        """
        Default constructor of class OptimalPartition
        :param filename: String. e.g "../data/input.txt"
        """
        self.binSizes=[]
        self.noOfBins = 0
        self.inputValues=[] # Space complexity will be O(n) since storing
                            # all input values from file
        self.filename = filename

    def getOptimalBinSizes(self, noOfInput, noOfBins):
        """
        Function to compute optimal bin size from given input
            e.g. noOfBins = 3, and noOfInput = 8, then self.binSizes = [3, 3, 2]
        and popluate the value of optimalBinSizes in instance variable :
        self.binSizes
        :param noOfInput: Int.
        :param noOfBins: Int
        :return: None.
        """
        while noOfBins>=1:
            self.binSizes.append(noOfInput//noOfBins)
            noOfInput -= noOfInput//noOfBins
            noOfBins -= 1

    def readInputFile(self):
        """
        Function that reads input file line by line and stores the input
        values into self.inputValues(list) instance variable (Assumption: Input
        file not too big for in-memory storage)
        :return: None
        """
        with open(self.filename, 'r') as fileHandler:
            self.noOfBins = int(fileHandler.readline().strip())
            line = fileHandler.readline() # reading first input line
            while (line):
                self.inputValues.append(int(line.strip()))
                line = fileHandler.readline()

        self.getOptimalBinSizes(len(self.inputValues), self.noOfBins)

    def performBinning(self, outputFile="../data/output.txt"):
        """
        Function that performs the optimal binning. Core function
        :param outputFile : String. Filename of the output File. Default
        value is the file in the data folder
        :return: None
        """
        self.inputValues.sort() # sort function takes O(nlog(n)) time
        low = 0
        with open(outputFile, "w") as fileHandler:
            for item in self.binSizes:
                high = low+item
                values = self.getBinValues(low, high)
                fileHandler.write(values+"\n")
                low = high

    def getBinValues(self, low, high):
        """
        Function to extract binValues from self.inputValues and return them
        as string seperated by space
        :param low: Int . lower index for self.inputValues
        :param high: Int. Higher index for self.inputValues
        :return: String
        """
        values = str(self.inputValues[low:high])[1:-1].split(",")
        values = " ".join(values)
        return values

    def runBinning(self, outputfile="../data/output.txt"):
        """
        Wrapper function to perform binning. It calls readInputFile and
        performBinning in that order
        :param outputFile : String. Filename of the output File. Default
        value is the file in the data folder
        :return: None
        """
        self.readInputFile()
        self.performBinning(outputfile)

def main():
    """
    Main method for the class OptimalPartition. Takes argument from the
    command line.
        e.g python OptimalPartition.py ../data/input.txt ../data/output.txt
    :return: None
    """
    arguments = sys.argv[1:]
    opt = OptimalPartition(arguments[0])
    opt.runBinning(arguments[1])

if __name__ == "__main__":
    main()

