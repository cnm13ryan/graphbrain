from graphbrain.memory.leveldb import LevelDB


def hypergraph(locator_string):
    return LevelDB(locator_string)