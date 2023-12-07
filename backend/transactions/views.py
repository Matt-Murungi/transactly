from rest_framework.views import APIView
from rest_framework.generics import ListAPIView
from .serializer import TransactionSerializers
from .models import Transactions
from rest_framework.pagination import LimitOffsetPagination


class TransactionListView(ListAPIView):
    queryset = Transactions.objects.all()
    serializer_class = TransactionSerializers
    pagination_class = LimitOffsetPagination
