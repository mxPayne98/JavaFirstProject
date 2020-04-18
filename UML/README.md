# Order management system
## Class Diagram
![Alt text](./class.png?raw=true "Title")

<p>
A Customer has 2 attributes:
<ul>
<li>name</li>
<li>location</li>
</ul>
And can perform the following 2 action (methods):
<ul>
<li>Send an order</li>
<li>Receive an order</li>
</ul>
One Customer can have many orders and an order can have one and only one Customer. <br>
An Order has 2 attributes:
<ul>
<li>date</li>
<li>number</li>
</ul>
It can perform the following 2 action (methods):
<ul>
<li>Confirm an order</li>
<li>Close an order</li>
</ul>
</p>
SpeacialOrder and NormalOrder are 2 types of Order that inherit properties from Order class. <br>

## Use Case Diagram
![Alt text](./usecase.png?raw=true "Title")

<p>
A customer interacts with the Order management systems by placing an order.
An order can be of 2 types Special or Normal.
</p>

## Sequence Diagram
![Alt text](./sequence.png?raw=true "Title")

<p>
An object of customer class dispatches a sendOrder message to Order class (sends an order). The Order object receive the message and sends a confirm message to the NormalOrder or SpeacialOrder object. The respective order invokes dispatch call on itsef and returns confirmation to the calling Order object which inturn confirms to its caller Customer object.
</p>

## Activity Diagram
![Alt text](./activity.png?raw=true "Title")