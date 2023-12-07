from rest_framework.views import APIView
from rest_framework.generics import ListAPIView, RetrieveAPIView
from .serializer import TransactionSerializer
from .models import Transactions
from rest_framework.pagination import LimitOffsetPagination
from rest_framework import mixins
from datetime import datetime
from rest_framework.response import Response
from rest_framework import status


class TransactionListView(ListAPIView):
    queryset = Transactions.objects.all()
    serializer_class = TransactionSerializer
    pagination_class = LimitOffsetPagination


class DetailedTransactionView(RetrieveAPIView):
    queryset = Transactions.objects.all()
    serializer_class = TransactionSerializer
    lookup_field = "id"


class TransactionsByDate(APIView):
    def get(self, request):
        if "end_date" not in request.query_params:
            start_date = request.query_params["start_date"]
            start_datetime = datetime.strptime(start_date, "%Y-%m-%d")
            transactions = Transactions.objects.filter(txfinish__gte=start_datetime)
        elif "start_date" not in request.query_params:
            end_date = request.query_params["end_date"]
            end_datetime = datetime.strptime(end_date, "%Y-%m-%d")
            transactions = Transactions.objects.filter(txfinish__lte=end_datetime)
        elif (
            "start_date" not in request.query_params
            and "end_date" not in request.query_params
        ):
            transactions = Transactions.objects.all()
        else:
            start_date = request.query_params["start_date"]
            end_date = request.query_params["end_date"]
            start_datetime = datetime.strptime(start_date, "%Y-%m-%d")
            end_datetime = datetime.strptime(end_date, "%Y-%m-%d")
            if start_datetime > end_datetime:
                return Response(
                    "Start date can not be greater than end date",
                    status=status.HTTP_400_BAD_REQUEST,
                )
            transactions = Transactions.objects.filter(
                txfinish__gte=start_datetime, txfinish__lte=end_datetime
            )

        serializer = TransactionSerializer(transactions, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)
