from fastapi import FastAPI
from models import products
app = FastAPI()
@app.get("/")
def home():
    return "home page"
product = [
products(1,"watch"),
products(2,"laptop")
]
@app.get("/product")
def all_products():
    return product