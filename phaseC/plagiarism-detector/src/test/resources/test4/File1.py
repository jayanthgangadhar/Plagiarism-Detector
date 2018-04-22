import pickle
import numpy as np
import pandas as pd
from collections import defaultdict
def predict(inp):
    print ("Inside Predict")
    print ("Input recieved : {0}".format(inp))

    dictOfItemIdVector = readDictFromFile("../output/dictOfItemVector.pickle")

    cosineSimilarityMatrix = computeSimilarity(dictOfItemIdVector[0],
                                               dictOfItemIdVector)

    df = cosineSimilarityMatrix.transpose().sort_values(by=0,
                                                       ascending=False).head()
    print("Top 5 recommended products : {0}".format(df.index.values))

    result = returnValue(df)

    print ("succesfuly computed result")

    return result

def readDictFromFile(filename):
    with open(filename, 'rb') as handle:
        dictToFile = pickle.load(handle)
    return dictToFile


def square_rooted(x):
    return round(np.sqrt(np.sum(np.dot(x, x))), 3)


def cosine_similarity2(x, y):
    numerator = np.sum(a * b for a, b in zip(x, y))
    denominator = square_rooted(x) * square_rooted(y)
    return round(numerator / float(denominator), 3)


def createColumnsForCosineSimilarity(dictOfItemIdVector):
    columns = []
    for key, values in dictOfItemIdVector.items():
        columns.append(key)
    return columns[:]


def computeSimilarity(X, dictOfItemIdVector):
    print("Starting building compute similarity")
    columns = createColumnsForCosineSimilarity(dictOfItemIdVector)
    cosineSimilarityMatrix = pd.DataFrame(columns=columns)
    print("Built empty dataframe")
    tempDict = {}

    for key, value in dictOfItemIdVector.items():
        tempDict[key] = cosine_similarity2(X, value)

    cosineSimilarityMatrix = cosineSimilarityMatrix.append(tempDict,
                                                           ignore_index=True)

    return cosineSimilarityMatrix.copy()


def returnValue(df):
    # print ("Inside returnValue. df received: ",df)
    # print ("Type of df : ",type(df))
    result = defaultdict(list)
    # print ("after defaultdict initilazation")
    count = 1
    for index, rows in df.iterrows():
        # print ("Inside for loop, iteration : ",count)
        result["item" + str(count) + "Suggested"].append(str(index))
        result["item" + str(count) + "Suggested"].append(
            tuple(("confidenceLevel", str(rows[0] * 100) + "%")))
        result["item" + str(count) + "Suggested"].append(tuple(
            ("suggestedProperty", str(getPropertyVectorForItemId(index)))))
        count += 1

    return result

def getPropertyVectorForItemId(itemId):
    item_prop = pd.read_pickle("../output/item_prop.pickle")

    return list(set(item_prop.loc[item_prop.itemid == itemId].property.values))

def preProcessDF(item_prop):
    item_prop['property'] = item_prop['property'].replace(["categoryid"], 0)
    item_prop['property'] = item_prop['property'].replace(["available"], 1)
    item_prop['property'] = pd.to_numeric(item_prop.property.values)
    return item_prop




