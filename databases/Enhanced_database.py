import sqlalchemy as db
from sqlalchemy import create_engine, and_, func, text
from sqlalchemy.orm import sessionmaker
from bson.json_util import dumps


def create_session(db_url):
    """
    This function takes a formatted db url and returns a session object to be used for db operations.

    :param db_url: Formatted db url
    :return: db connection session
    """
    engine = create_engine(db_url)
    session = sessionmaker(bind=engine)
    return session()

class AnimalShelter(object):

    def __init__(self, username='aacuser', password='aacuser'):
        # Replacing the old code (commented out) that connected to the mongodb with the new code that connects 
        # to the postgressql database using sqlalchemy
        url = "postgresql://{username}:{password}@localhost:5432/AAC"
        self.client = create_session(url)
        
        # This is the old code from the original mongodb project
        # self.client = MongoClient('mongodb://%s:%s@localhost:37288/AAC' % (username, password))
        # self.AAC = self.client['AAC']

    def create(self, data):
        return_value = False
        if data is not None and isinstance(data, dict): #Make sure data is not None and is a dictonary
            print(f'create data: {data}')
            # Changing this line from using mongodb to sqlalchemy
            output = self.client.insert().values(data)
            print(f'create return: {output}')
            return_value = True
        else:
            print("Nothing to save because data parameter is empty")
        print(f'create return: {return_value}')
        return return_value

    def read(self, query):
        return_value = None
        if query is not None and isinstance(query, list): #Make sure query is not None and is a list
            print(f'read query: {query}')
            # Replacing the call to mongodb with the sqlalchemy equivalent
            return_value = self.client.select(query) # This is the same as SELECT * FROM query where query is the table 
            return_value = return_value.fetchall()
        else:
            print("Query was not a dictionary")
        print(f'read return: {return_value}')
        return return_value
    
    def update(self, id, update_data):
        return_value = False
        if update_data is not None and isinstance(update_data, dict):
            # update_data dictionary should be of the form {<column_name>: <cell_value>}
            return_value = self.client.update("Animals").values(attribute = update_data).where(f"animal_id = {id}")
            # return_value = self.AAC.animals.update_one(data, {'$set': update_data})

        else:
            print("Nothing to update, because data parameter is empty")
        return return_value
    
    def delete(self, delete_id):
        return_value = None
        if update_data is not None and isinstance(delete_id, dict):
            # Just look up the animal_id id in the Animals table and delete it
            return_cmd_value = self.client.delete("Animals").where(f'animal_id = {delete_id}')
            print(f'delete_cmd_return: {return_cmd_value}')
        else:
            print("Nothing to delete, because delete_id parameter is empty") 
        return return_cmd_value




    