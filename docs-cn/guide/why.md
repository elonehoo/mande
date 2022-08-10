# Why Mande

:::info note
This article defaults that you have the same needs as our team,
and you have a unified management of an OA system,
and this OA system has a strong uncertainty, which brings you great anxiety.
:::

## The need for a Mande forwarding runner

We only need mande to forward the request.
If the target server is down, the request will be saved,
and these unsent requests will be sent one by one through the scheduled task.
Of course, we also combine the synchronous and asynchronous in JavaScript.
concept. Forwarding requests in mande can also be synchronous and asynchronous.
When we choose synchronous mande, we will directly return the content returned
by the target server. If we choose asynchronous, unsuccessful requests will be
stored, and subsequent requests will be made until the request is made. success.

Of course, there is another advantage of using mande.
We can run mande on an independent server,
so that our APP can have many independent application terminals,
and only need to configure the IP address of mande once on the OA,
and our application The ends can be all over the place.

Continue reading in the [Getting Started Guide](/guide/).

## How is Mande Different from X?

Since there is really no middleware that is the same as mande,
it is not very comparable. If we find similar middleware,
then we will use it and feel the difference between the two.

Of course, it may also be that we have completely different brains,
so we have a completely different demand.
