FROM mongo:4.0.4
ADD mongodb/scripts/init_replicaset.js init_replicaset.js
