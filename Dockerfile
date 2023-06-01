FROM quay.io/projectquay/golang:1.20 as builder

WORKDIR /go/src/app
COPY . .
ARG TARGETARCH TARGETOS
RUN make build TARGETARCH=$TARGETARCH TARGETOS=$TARGETOS

FROM scratch
WORKDIR /
COPY --from=builder /go/src/app/t-bot .
COPY --from=alpine:latest /etc/ssl/certs/ca-certificates.crt /etc/ssl/certs/
ENTRYPOINT ["./t-bot", "start"]
